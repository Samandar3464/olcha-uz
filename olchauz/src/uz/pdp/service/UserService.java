package uz.pdp.service;

import uz.pdp.Constants;
import uz.pdp.dataBase.DataBase;
import uz.pdp.modul.User;

// user bn favourite ga  1 ta id generatsiya boldi
public class UserService implements DataBase, Constants, BaseService {
    public int dafaultUserId = 0;

    public String checkTelefon(String telefonNum) {//  yangi yuseni royhatda bor yoqligini
        for (User user : users) {
            if (user.getTelNumber().equals(telefonNum)) {
                System.out.println(" This number already registred this sayt ");
                return null;
            }
        }
        return telefonNum;
    }

    public User registration(String telNumber, String name, String surName, String password) {
        User user = new User();
        user.setTelNumber(telNumber);
        user.setName(name);
        user.setSurName(surName);
        user.setPassword(password);
        user.setRole(USER);
        return user;

    }

    public User login(String name, String password) {
        for (User user : users) {
          if (user!=null) {
                if (user.getName().equals(name) && user.getPassword().equals(password)) {
                    dafaultUserId = user.getId();

                    return user;
                }
            }
        }
        return null;
    }

    public void listUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public User upToDateUserInfo(User user, String name, String surName, String telNumber,
                                 String password, int age, String cardNumber, double amount) {
        user.setName(name);
        user.setSurName(surName);
        user.setTelNumber(telNumber);
        user.setPassword(password);
        user.setAge(age);
        user.setCardNumber(cardNumber);
        user.setAmount(amount);
        System.out.println(user);
        return user;
    }

public int adminId(){
    for (User user : users) {
        if (user.getRole().equals(ADMIN)){
            return user.getId();
        }
    }
    return 0;
}

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Object getById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
