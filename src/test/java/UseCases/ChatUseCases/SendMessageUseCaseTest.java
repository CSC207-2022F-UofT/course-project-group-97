package UseCases.ChatUseCases;

import Entities.*;
import InterfaceAdapters.ChatGateway;
import UseCases.chat.ChatRegUseCase;
import UseCases.chat.ChatRepoUseCase;
import UseCases.chat.SendMessageUseCase;
import UseCases.dataretrieval.CurrentGraph;
import UseCases.dataretrieval.GetChats;
import UseCases.dataretrieval.SaveGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SendMessageUseCaseTest {

    @Test
    void testaddMessage() {
        UserGraph realGraph = CurrentGraph.getGraph();
        ChatRepoUseCase.resetChats();

        //should successfully add a new message to testChatroom

        User u1 = new User("clark", "12345");
        User u2 = new User("kevin", "54321");

        Set<User> users = new HashSet<>();
        users.add(u1);
        users.add(u2);

        UserGraph ug = new UserGraph();
        ug.addUser(u1);
        ug.addUser(u2);

        new SaveGraph(ug);

        //u1 is current user
        CurrentUser CU = new CurrentUser();
        CU.setUser(u1.getUsername());

        ChatRegUseCase chatReg = new ChatRegUseCase();
        chatReg.createChatroom(u1, u2);

        // u1 - clark sends the message
        String message = "hi kein how are you";

        SendMessageUseCase sendMessageUseCase = new SendMessageUseCase();
        sendMessageUseCase.addMessage(u1.getUsername().getData(), u2.getUsername().getData(), message); // null pointer exception

        boolean actual = false;

        ChatRepoUseCase chatRepoUseCase = new ChatRepoUseCase();
        Chatroom chatroom = chatRepoUseCase.getChatroom(users);
        List<Message> conv = chatroom.getConversation();

        for (Message msg : conv) {
            if (msg.getMessageText().equals(message) && msg.getMessageUser().getUsername().getData().equals(u1.getUsername().getData())) {
                actual = true;
                break;
            }
        }

        boolean expected = true;

        Assertions.assertEquals(expected, actual);
        new SaveGraph(realGraph);
    }
}
