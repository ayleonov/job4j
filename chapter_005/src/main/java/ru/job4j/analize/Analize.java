package ru.job4j.analize;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        info.added = current.size();

        ArrayList<Integer> idsCurrent = new ArrayList<>(current.size());
        for (int i = 0; i < current.size(); i++) {
            idsCurrent.add(current.get(i).id);
        }

        for (int i = 0; i < previous.size(); i++) {
            User temp = previous.get(i);
            if (idsCurrent.contains(temp.id)) {
                if (!(temp.name.equals(current.get(i).name))) {
                    info.changed++;
                }
                info.added--;
            } else {
                info.deleted++;
            }
        }
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}
