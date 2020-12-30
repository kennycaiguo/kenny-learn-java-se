package javax_swing;
/*
  注意：1FileDialog的用法在jdk帮助文档里面找不到，必须在网上找
   2.记事本的撤销功能的实现比较复杂：
   <1.>创建UndoManager对象：UndoManager undomgr=new UndoManager();
   <2.>创建JTextArea的文档对象并且添加文档监听器
   area.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
								@Override
								public void undoableEditHappened(UndoableEditEvent e) {
									// TODO Auto-generated method stub
									
									undomgr.addEdit((e.getEdit()));								
								 }								
							});		
		<3>.为撤销菜单添加动作监听器
		undoMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				undomgr.undo();
			}});
			
	3.记事本的删除功能比较有技巧：
	   利用JTextArea的.replaceSelection("");   函数将选中的文本替换为空字符串"".
			
 */
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.undo.UndoManager;
 
public class JTextPaneNotepad {
	
	public static JFrame f=new JFrame("Java记事本");
	static JMenuBar  bar=new JMenuBar();
 
	JMenu fileMenu =new JMenu("文件");
	JMenu editMenu =new JMenu("编辑");
	JMenu formatMenu =new JMenu("格式");
	JMenu helpMenu =new JMenu("帮助");
	 
		
	JMenuItem newMenu=new JMenuItem("新建");
	JMenuItem openMenu=new JMenuItem("打开");
	JMenuItem saveMenu=new JMenuItem("保存");
	JMenuItem saveAsMenu=new JMenuItem("另存为");
	
	JMenuItem closeMenu=new JMenuItem("退出");
	JMenuItem helpMenu1=new JMenuItem("查看帮助");
	JMenuItem aboutMenu=new JMenuItem("关于本程序");
	
	 JMenuItem undoMenu=new JMenuItem("撤销");
	 static JMenuItem cutMenu=new JMenuItem("剪切");
	 static JMenuItem copyMenu=new JMenuItem("复制");
	 static JMenuItem pasteMenu=new JMenuItem("粘贴"); 
	JMenuItem deleteMenu=new JMenuItem("删除"); 
	JMenuItem findMenu=new JMenuItem("查找"); 
	JMenuItem replaceMenu=new JMenuItem("替换"); 
	JMenuItem gotoMenu=new JMenuItem("转到"); 
	JMenuItem selectAllMenu=new JMenuItem("全选"); 
	JMenuItem dateTimeMenu=new JMenuItem("时间/日期"); 
	
	JMenuItem fontMenu=new JMenuItem("字体"); 
	JMenuItem colorMenu=new JMenuItem("颜色"); 
	
	
	 
	//public static JTextArea area=new JTextArea(30,20);
	JTextPane jtp=new JTextPane();
	public void initNotepad() {
		
		jtp.setText("");
		String title="无标题文档-"+"Java记事本";
		 f.setTitle(title);
		jtp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 
				undoMenu.setEnabled(true);
				if(jtp.getSelectionEnd()>0) {
 				     if(jtp.getSelectedText()=="") {
 				    	cutMenu.setEnabled(false);
				    	 copyMenu.setEnabled(false);
 				     }else {
 				    	 cutMenu.setEnabled(true);
 				    	 copyMenu.setEnabled(true);
 				    	 
 				     }
 				   }
		}
	});
		//area.getDocument().addDocumentListener(new Swing_OnValueChanged ());
		
		newMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String content=jtp.getText();
				if(content.length()==0) {
					
					String title="无标题文档-"+"Java记事本";
					 
					f.setTitle(title);
				}else {
					int option=JOptionPane.showConfirmDialog(null, "保存文件？", "保存提示", JOptionPane.YES_NO_CANCEL_OPTION); 
				       switch(option) {
				    	   case 0:
				    		   String filetitle=f.getTitle();
								String[]parts=filetitle.split("-");
								String savefilename=parts[0];
								File savefile=new File(savefilename);
								FileOutputStream fos;
								try {
									fos = new FileOutputStream(savefile);
									OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
									osw.write(jtp.getText().replaceAll("\n", "\r\n"));
									osw.close();
									
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}finally {
									jtp.setText("");
									String title="无标题文档-"+"Java记事本";
									 f.setTitle(title);
								}
								
				    		   break;
				    	   case 1:
				    		   jtp.setText("");
				    		   String title="无标题文档-"+"Java记事本";
								 
								f.setTitle(title);
				    		   break;
				    		 default:
				    			 break;
				       }
				}
				jtp.getFocusListeners();
				
			}});
		
		openMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog fd=new FileDialog(f, "选择要打开的文件",FileDialog.LOAD);
				fd.setVisible(true);
				String path=fd.getDirectory();
				String filename= fd.getFile();
				String title=path+filename+"-"+f.getTitle();
				f.setTitle(title);
				File file=new File(path,filename);
				try {
					FileInputStream fis=new FileInputStream(file);
					InputStreamReader isr=new InputStreamReader(fis,"gbk");
          			BufferedReader bfr =new BufferedReader(isr);
					String line=null;
					String content="";
					while((line=bfr.readLine())!=null) {
						content+=line+"\r\n";
					}
					jtp.setText(content);
					   
					 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		saveMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String filetitle=f.getTitle();
				String[]parts=filetitle.split("-");
				String savefilename=parts[0];
				File savefile=new File(savefilename);
				if(!savefile.exists()) {
				    saveFile() ;
				}else {
					FileOutputStream fos;
					try {
						fos = new FileOutputStream(savefile);
						OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
						osw.write(jtp.getText());
						osw.close();
						f.setTitle(savefilename+"-Java记事本");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
      }); 
		
		saveAsMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveFile();
			}});
//		switchMenu.add(CMenu);
//		switchMenu.add(DMenu);
//		switchMenu.add(EMenu);
//		switchMenu.add(FMenu);
		
		closeMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			    if(jtp.getText().length()!=0) {
			    	    int option=JOptionPane.showConfirmDialog(null, "保存文件？", "退出保存提示", JOptionPane.YES_NO_CANCEL_OPTION); 
				       switch(option) {
				    	   case 0:
				    		   String filetitle=f.getTitle();
								String[]parts=filetitle.split("-");
								String savefilename=parts[0];
								File savefile=new File(savefilename);
								FileOutputStream fos;
								try {
									fos = new FileOutputStream(savefile);
									OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
									osw.write(jtp.getText().replaceAll("\n", "\r\n"));
									osw.close();
									
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
								
								System.exit(0);
				    		   break;
				    	   case 1:
				    		   System.exit(0);
				    	   default:
				    		   break;
				       }
			    }else {
			    	
			    	System.exit(0);
			    }
			    	
			}});
		UndoManager undomgr=new UndoManager();
		jtp.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
								@Override
								public void undoableEditHappened(UndoableEditEvent e) {
									// TODO Auto-generated method stub
									
									undomgr.addEdit((e.getEdit()));								
								 }								
							});		
		
	undoMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				undomgr.undo();
			}});
		cutMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jtp.cut();
			}});
		 copyMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jtp.copy();
			}});
		 
		 pasteMenu.addActionListener(new ActionListener() {
			 
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 jtp.paste();
			 }});
		 
		 deleteMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  jtp.replaceSelection("");
			}});
		 
		fileMenu.add(newMenu);
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		fileMenu.add(saveAsMenu);
		//fileMenu.add(switchMenu);
		fileMenu.add(closeMenu);
		
		editMenu.add(undoMenu);
		editMenu.add(cutMenu);
		editMenu.add(copyMenu);
		editMenu.add(pasteMenu);
		editMenu.add(deleteMenu);
		editMenu.add(findMenu);
		editMenu.add(replaceMenu);
		editMenu.add(gotoMenu);
		editMenu.add(selectAllMenu);
		editMenu.add(dateTimeMenu);
		
		undoMenu.setEnabled(false);
		cutMenu.setEnabled(false);
		copyMenu.setEnabled(false);
		pasteMenu.setEnabled(false);
		deleteMenu.setEnabled(false);
		
		
		formatMenu.add(fontMenu);
		formatMenu.add(colorMenu);
		
		helpMenu.add(helpMenu1);
		helpMenu.add(aboutMenu);
		
		
		bar.add(fileMenu);
		bar.add(editMenu);
		bar.add(formatMenu);
		bar.add(helpMenu);
		f.add(bar,BorderLayout.NORTH);
		JScrollPane scrollpane=new JScrollPane(jtp);
		scrollpane.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollpane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				 
		f.add(scrollpane);
		FrameTool.CenterFrame(f, 600, 500);
		f.setVisible(true);
	}
	public static void UpdateFrameTitle(JFrame f) {
		String title=f.getTitle();
		if(!title.contains("(未保存)")) title+="(未保存)";
		f.setTitle(title);
		
	}
	
	public void saveFile() {
		FileDialog fd=new FileDialog(f, "保存文件",FileDialog.SAVE);
		fd.setVisible(true);
		String path=fd.getDirectory();
		String filename= fd.getFile();
		String title=path+filename+"-"+f.getTitle();
		f.setTitle(title);
		File file=new File(path,filename);
		try {
			FileOutputStream fos=new FileOutputStream(file);
			OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
			osw.write(jtp.getText().replaceAll("\n", "\r\n"));
			osw.close();
			f.setTitle(path+filename+"-Java记事本");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	 
    public static void main(String[] args) {
    	new JTextPaneNotepad().initNotepad();
	}
}
