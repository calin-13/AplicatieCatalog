package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MaterieDAO {

    public void addSubject(Materie materie) {
        try (Connection conn = DbUtils.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO materie (nume) VALUES (?)");
            stmt.setString(1, materie.getNume());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Materie> getAllSubjects() {
        List<Materie> subjects = new ArrayList<>();
        try (Connection conn = DbUtils.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM materie");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                subjects.add(new Materie(id, nume));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subjects;
    }
}