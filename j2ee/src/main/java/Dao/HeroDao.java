package Dao;

import Bean.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//与数据库交互层
public class HeroDao {
    public HeroDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://192.168.3.101:3306/how2java?characterEncoding=UTF-8",
                "root",
                "root");
    }

    //获取行数
    public int getTotal() {
        int total = 0;
        try (Connection c = getConnection();
             Statement s = c.createStatement();) {
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println("total:" + total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void addHero(Hero hero) {
        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, hero.getName());
            ps.setDouble(2, hero.getHp());
            ps.setInt(3, hero.getDamage());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                hero.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHero(Hero hero) {
        String sql = "update hero set name=?,hp=?,damage=?,where id=?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, hero.getName());
            ps.setDouble(2, hero.getHp());
            ps.setFloat(3, hero.getDamage());
            ps.setInt(4, hero.getId());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHero(Integer id) {
        try (Connection c = getConnection();
             Statement s = c.createStatement()) {
            String sql = "delete from hero where id=" + id;

            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Hero get(Integer id) {
        Hero hero = null;
        try (Connection c = getConnection();
             Statement s = c.createStatement();) {
            String sql = "seletct * from hero where id=" + id;

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                hero = new Hero();
                hero.setId(id);
                hero.setName(rs.getString(2));
                hero.setHp(rs.getDouble("hp"));
                hero.setDamage(rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    public List<Hero> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Hero> list(int start, int count) {
        List<Hero> heros = new ArrayList<Hero>();
        String sql = "seletct * from hero order by id desc limit ?,?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hero hero = new Hero();
                hero.setId(rs.getInt(1));
                hero.setName(rs.getString(2));
                hero.setHp(rs.getDouble("hp"));
                hero.setDamage(rs.getInt(4));
                heros.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heros;
    }

}
