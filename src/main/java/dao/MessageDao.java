package dao;

import model.Message;

import java.util.List;

public class MessageDao implements IDao<Message> {
    @Override
    public Message findById(Integer id) {
        return null;
    }

    @Override
    public List<Message> findAll() {
        return List.of();
    }

    @Override
    public void save(Message o) {

    }

    @Override
    public void update(Message o) {

    }

    @Override
    public void delete(Integer id) {

    }
}
