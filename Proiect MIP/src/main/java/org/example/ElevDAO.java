package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ElevDAO {

    public void addStudent(Elev elev, int classId) {
        try (Connection conn = DbUtils.getConnection()) {
            PreparedStatement stmt;
            if (elev instanceof ElevBursier) {
                stmt = conn.prepareStatement("INSERT INTO elev (nume, prenume, medie, bursa, id_clasa) VALUES (?, ?, ?, ?, ?)");
                stmt.setDouble(4, ((ElevBursier) elev).getBursa());
            } else {
                stmt = conn.prepareStatement("INSERT INTO elev (nume, prenume, medie, bursa, id_clasa) VALUES (?, ?, ?, NULL, ?)");
            }
            stmt.setString(1, elev.getNume());
            stmt.setString(2, elev.getPrenume());
            stmt.setDouble(3, elev.getMedie());
            stmt.setInt(5, classId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Elev> getStudentsByClass(int classId) {
        List<Elev> students = new ArrayList<>();
        try (Connection conn = DbUtils.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM elev WHERE id_clasa = ?");
            stmt.setInt(1, classId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                String prenume = rs.getString("prenume");
                double medie = rs.getDouble("medie");
                double bursa = rs.getDouble("bursa");

                if (bursa > 0) {
                    students.add(new ElevBursier(id, nume, prenume, medie, bursa));
                } else {
                    students.add(new ElevNeBursier(id, nume, prenume, medie));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}