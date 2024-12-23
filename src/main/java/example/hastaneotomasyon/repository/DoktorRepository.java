package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.Doktor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DoktorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Doktor> findAll() {
        String sql = "SELECT * FROM doktor";
        return jdbcTemplate.query(sql, new DoktorRowMapper());
    }

    public Doktor findById(int id) {
        String sql = "SELECT * FROM doktor WHERE doktor_id = ?";
        return jdbcTemplate.queryForObject(sql, new DoktorRowMapper(), id);
    }


    public int save(Doktor doktor) {
        String sql = "INSERT INTO doktor (doktor_id,isim, soyisim, unvan, bolum_id) VALUES (?, ?, ?, ?,?)";
        return jdbcTemplate.update(sql,doktor.getDoktorId(), doktor.getIsim(), doktor.getSoyisim(), doktor.getUnvan(), doktor.getBolumId());
    }

    public int update(Doktor doktor) {
        String sql = "UPDATE doktor SET isim = ?, soyisim = ?, unvan = ?, bolum_id = ? WHERE doktor_id = ?";
        return jdbcTemplate.update(sql, doktor.getIsim(), doktor.getSoyisim(), doktor.getUnvan(), doktor.getBolumId(), doktor.getDoktorId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM doktor WHERE doktor_id = ?";
        return jdbcTemplate.update(sql, id);
    }

    private static class DoktorRowMapper implements RowMapper<Doktor> {
        @Override
        public Doktor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Doktor doktor = new Doktor();
            doktor.setDoktorId(rs.getInt("doktor_id"));
            doktor.setIsim(rs.getString("isim"));
            doktor.setSoyisim(rs.getString("soyisim"));
            doktor.setUnvan(rs.getString("unvan"));
            doktor.setBolumId(rs.getInt("bolum_id"));
            return doktor;
        }
    }


}
