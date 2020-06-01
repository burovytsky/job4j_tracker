package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class SqlTracker implements Store {
    private Connection cn;
    private PreparedStatement st;

    @Override
    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            createTable();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Item add(Item item) {
        try {
            st = cn.prepareStatement("insert into item (id, name) values (?, ?)");
            st.setString(1, generateId());
            st.setString(2, item.getName());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean rsl = false;
        try {
            st = cn.prepareStatement("update item set name = ? where item.id = ?");
            st.setString(1, item.getName());
            st.setString(2, id);
            if (st.executeUpdate() > 0) {
                rsl = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        try {
            st = cn.prepareStatement("delete from item WHERE item.id = ?");
            st.setString(1, id);
            if (st.executeUpdate() > 0) {
                rsl = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from item");
            while (rs.next()) {
                Item item = new Item(rs.getString("name"));
                item.setId(rs.getString("id"));
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try {
            st = cn.prepareStatement("select * from item WHERE item.name = ?");
            st.setString(1, key);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Item item = new Item(resultSet.getString("name"));
                item.setId(resultSet.getString("id"));
                rsl.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        try {
            st = cn.prepareStatement("select * from item WHERE item.id = ?");
            st.setString(1, id);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                item = new Item(resultSet.getString("name"));
                item.setId(resultSet.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    private void createTable() {
        try {
            Statement st = cn.createStatement();
            st.executeQuery("create table if not exists item (id varchar(100), name varchar(30));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}
