package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class WhatsappRepository {

    //Assume that each user belongs to at most one group
    //You can use the below mentioned hashmaps or delete these and create your own.
    private HashMap<Group, List<User>> groupUserMap;
    private HashMap<Group, List<Message>> groupMessageMap;
    private HashMap<Message, User> senderMap;
    private HashMap<Group, User> adminMap;
    private HashSet<String> userMobile;
    private int customGroupCount;
    private int messageId;
    private HashMap<String, User> users;
    public WhatsappRepository(){
        this.groupMessageMap = new HashMap<Group, List<Message>>();
        this.groupUserMap = new HashMap<Group, List<User>>();
        this.senderMap = new HashMap<Message, User>();
        this.adminMap = new HashMap<Group, User>();
        this.userMobile = new HashSet<>();
        this.customGroupCount = 0;
        this.messageId = 0;
        this.users = new HashMap<>();
    }

    public String createUser(String name, String mobile){
        if(users.containsKey(mobile))
            return "User already exists";
        User user = new User(name, mobile);
        users.put(mobile, user);
        System.out.println(users.get(mobile));
        return "SUCCESS";
    }
    public User getUser(String name){
        return users.get(name);
    }
    public Group createGroup(List<User> users){
        if(users.size() < 2) return null;
        String name = "";
        int nop = 0;
        Group group;
        if(users.size() == 2){
            name = users.get(1).getName();
            nop = users.size();
            //group = new Group(name, nop);
            //groupUserMap.put(group, users);
        }
        name = "Group"+" "+users.size();
        nop = users.size();
        group = new Group(name, nop);
        groupUserMap.put(group, users);
        return group;
    }
    public List<User> getGroup(String name){
        Set<Group> group = groupUserMap.keySet();
        for(Group grp : group)
            if(grp.getName().equals(name))
                return groupUserMap.get(group);
        return null;
    }

    public int createMessage(String content){
        return 0;
    }

    public int sendMessage(Message message, User sender, Group group){
        return 0;
    }
    public String changeAdmin(User approver, User user, Group group){
        return "";
    }

    public int removeUser(User user){
        return 0;
    }

    public String findMessage(Date start, Date end, int K){
        return "";
    }
}
