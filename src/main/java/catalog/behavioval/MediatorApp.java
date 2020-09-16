package catalog.behavioval;

import java.util.HashSet;
import java.util.Set;

public class MediatorApp {

    public static void main(String[] args) {
        TextChat textChat = new TextChat();
        Admin darkside = new Admin(textChat, "Darkside");
        User vasya = new User(textChat, "Vasya");
        User petya = new User(textChat, "Petya");
        User sasha = new User(textChat, "Sasha");
        User max = new User(textChat,  "Max");

        textChat.setAdmin(darkside);
        textChat.addUser(vasya);
        textChat.addUser(petya);
        textChat.addUser(sasha);
        textChat.addUser(max);

        sasha.setEnable(false);

        vasya.sendMessage("Hi");
        darkside.sendMessage("I'm an admin");
    }
}

abstract class AbstractUser {
    protected Chat chat;
    protected String name;
    private boolean enable;

    public AbstractUser(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
        this.enable = true;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isEnable() {
        return enable;
    }

    public void sendMessage(String msg) {
        chat.sendMessage(String.format("%s: %s", name, msg), this);
    }

    protected abstract void getMessage(String msg);
}

class User extends AbstractUser {

    public User(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    protected void getMessage(String msg) {
        System.out.println("User " + name + " got the message from " + msg);
    }
}

class Admin extends AbstractUser {

    public Admin(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    protected void getMessage(String msg) {
        System.out.println("Admin " + name + " got the message from " + msg);
    }
}

interface Chat {
    void sendMessage(String msg, AbstractUser user);
}

class TextChat implements Chat {
    private AbstractUser admin;
    private final Set<AbstractUser> users = new HashSet<>();

    public void setAdmin(AbstractUser u) {
        if (admin == null && u instanceof Admin) {
            admin = u;
        } else {
            throw new RuntimeException("Forbidden");
        }
    }

    public void addUser(AbstractUser user) {
        if (admin == null) {
            throw new RuntimeException("The admin of this chat is absent");
        }

        if (user instanceof User) {
            users.add(user);
        } else {
            throw new RuntimeException("Admin must not enter in an another chat");
        }
    }

    @Override
    public void sendMessage(String msg, AbstractUser user) {
        if (user instanceof Admin) {
            users.forEach(u -> u.getMessage(msg));
        } else {
            users.stream().filter(u -> u.isEnable() && u != user).forEach(u -> u.getMessage(msg));
            if (admin.isEnable()) {
                admin.getMessage(msg);
            }
        }
    }
}
