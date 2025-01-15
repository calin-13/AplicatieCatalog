package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClasaDAO {
    public void addClass(Clasa clasa) {
        try (Connection conn = DbUtils.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO clasa (nume) VALUES (?)");
            stmt.setString(1, clasa.getNume());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Clasa> getAllClasses() {
        List<Clasa> classes = new ArrayList<>();
        try (Connection conn = DbUtils.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM clasa");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                classes.add(new Clasa(id, nume));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }
}