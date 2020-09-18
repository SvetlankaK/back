package com.svetakvetko.demo.service;

import com.svetakvetko.demo.domain.Role;
import com.svetakvetko.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private static List<User> fakeUsers = new ArrayList<>();
    private static Map<Long, User> sashaAreYouHappyNow = new HashMap<>();

    static {
        Collections.addAll(fakeUsers,
                new User("Sveta", "gfhjkm", Collections.singletonList(new Role(1, "admin")), "email@com", "Sveta", "Kvetko", 3333, "06.04.2000", (long) 1),
                new User("kat17", "драсте", Collections.singletonList(new Role(2, "user")), "cat1717@mail.ru", "Анна", "Иванова", 200, "10.10.1999", (long) 2),
                new User("leadss", "fdeefe", Collections.singletonList(new Role(2, "user")), "liveliver@gmail.com", "Максим", "Вешалкин", 550, "07.09.1990", (long) 3),
                new User("great29", "совсемнегениальныйпароль", Collections.singletonList(new Role(2, "user")), "football_player@gmail.com", "Вадим", "Бабурченков", 320,
                        "17.01.1880", (long) 4));
        sashaAreYouHappyNow.put((long) 1, new User("Sveta", "gfhjkm", Collections.singletonList(new Role(1, "admin")), "email@com", "Sveta", "Kvetko", 3333, "06.04.2000", (long) 1));
        sashaAreYouHappyNow.put((long) 2, new User("kat17", "драсте", Collections.singletonList(new Role(2, "user")), "cat1717@mail.ru", "Анна", "Иванова", 200, "10.10.1999", (long) 2));
        sashaAreYouHappyNow.put((long) 3, new User("Sveta3", "gfhjkm", Collections.singletonList(new Role(1, "admin")), "email@com", "Sveta", "Kvetko", 3333, "06.04.2000", (long) 3));
        sashaAreYouHappyNow.put((long) 4, new User("Sveta4", "gfhjkm", Collections.singletonList(new Role(1, "admin")), "email@com", "Sveta", "Kvetko", 3333, "06.04.2000", (long) 4));
    }

    @Override
    public void create(User user) {
        sashaAreYouHappyNow.put(user.getUserId(), user);
//        fakeUsers.add(user);
    }

    @Override
    public void delete(Long userId) {
        sashaAreYouHappyNow.remove(userId);
//        fakeUsers = fakeUsers.stream().filter(user -> user.getUserId() != userId).collect(Collectors.toList());
    }

    @Override
    public User findById(Long userId) {
        return sashaAreYouHappyNow.get(userId);
//        return fakeUsers.stream().filter(user -> user.getUserId() == userId).findFirst().orElse(new User());

    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(sashaAreYouHappyNow.values());
//        return new ArrayList<>(fakeUsers);
    }

    @Override
    public User update(User user, long userId) {
        //fakeUsers = fakeUsers.stream().filter(u -> u.getUserId() != userId).collect(Collectors.toList());
//        fakeUsers.add(user);
//        return user;
        sashaAreYouHappyNow.remove(userId);
        sashaAreYouHappyNow.put(user.getUserId(), user);
        return sashaAreYouHappyNow.get(user.getUserId());
    }

    @Override
    public User findByLogin(String userLogin) {
        Long key = (long) 0;
        for (Map.Entry<Long, User> entry : sashaAreYouHappyNow.entrySet()) {
            if (entry.getValue().getUserLogin().equals(userLogin)) {
                key = entry.getKey();
            }
        }
        return sashaAreYouHappyNow.get(key);
//        Optional<User> optionalUser = fakeUsers.stream().filter(user -> user.getUserLogin().equals(userLogin)).findAny();
//        return optionalUser.orElseGet(User::new);
    }
}
