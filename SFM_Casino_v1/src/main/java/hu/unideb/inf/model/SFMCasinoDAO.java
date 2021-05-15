package hu.unideb.inf.model;

import java.util.List;

public interface SFMCasinoDAO extends AutoCloseable{
    public void saveUser(User2 a);
    public void deleteUser(User2 a);
    public void updateUser(User2 a);
    public List<User2> getUser();
}
