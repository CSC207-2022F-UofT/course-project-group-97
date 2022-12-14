package UseCases.chat;

import Entities.Chatroom;
import Entities.Message;
import Entities.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * This class is responsible for converting the chatroom entities to data the presenter can use to update the chat page
 */
public class ChatRenderUseCase {

    /**
     * This class is responsible for converting the raw chatroom entities into
     * data the presenter can use to update the chat page
     * @param user the current User that is logged in to the program
     */
    public ChatRenderResponseModel render(User user) {

        Map<Set<User>, Chatroom> map = ChatRepoUseCase.getUserChatrooms(user);

        ArrayList<ArrayList<ArrayList<String>>> responseModel = new ArrayList<>();

        for (Map.Entry<Set<User>, Chatroom> set : map.entrySet()) {

            ArrayList<ArrayList<String>> currChatroomList = new ArrayList<>();
            Chatroom chatroom= set.getValue();
            Object[] users = set.getKey().toArray();
            User user1 = (User) users[0];
            User user2 = (User) users[1];
            String username1 = user1.getUsername().getData();
            String username2 = user2.getUsername().getData();

            ArrayList<String> username1List = new ArrayList<>();
            ArrayList<String> username2List = new ArrayList<>();
            username1List.add(username1);
            username2List.add(username2);

            //added just now
            currChatroomList.add(username1List);
            currChatroomList.add(username2List);
            ArrayList<Message> convo = (ArrayList<Message>) chatroom.getConversation();

            for (Message m : convo) {
                ArrayList<String> messageList = new ArrayList<>();
                String messageUser = m.getMessageUser().getUsername().getData();
                String message = m.getMessageText();
                messageList.add(messageUser);
                messageList.add(message);
                currChatroomList.add(messageList);
            }
            responseModel.add(currChatroomList);
        }

        return new ChatRenderResponseModel(responseModel);
    }
}

