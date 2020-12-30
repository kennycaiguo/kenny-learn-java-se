package updDemos;

public class GroupChatMain {
    public static void main(String[] args) {
		GroupChatReceiver receiver =new GroupChatReceiver();
		receiver.start();
		GroupChatSender sender =new GroupChatSender();
		sender.start();
	}
}
