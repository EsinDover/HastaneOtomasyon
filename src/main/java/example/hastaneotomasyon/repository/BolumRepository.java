package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.Bolum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BolumRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Bolum> findAll() {
        String sql = "SELECT * FROM bolum";
        return jdbcTemplate.query(sql, new BolumRepository.BolumRowMapper());
    }

    public int save(Bolum bolum) {
        String sql = "INSERT INTO bolum (bolum_id, ad) VALUES (?,?)";
        return jdbcTemplate.update(sql, bolum.getBolum_id(),bolum.getAd());
    }

    public Bolum findById(int bolumId) {
        String sql = "SELECT * FROM bolum WHERE bolum_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Bolum b = new Bolum();
            b.setBolum_id(rs.getInt("bolum_id"));
            b.setAd(rs.getString("ad"));
            return b;
        }, bolumId);
    }

    public int update(Bolum bolum) {
        String sql = "UPDATE bolum SET ad = ? WHERE bolum_id = ?";
        return jdbcTemplate.update(sql,  bolum.getBolum_id(), bolum.getAd() );
    }

    public int delete(int bolumId) {
        String sql = "DELETE FROM bolum WHERE bolum_id = ?";
        return jdbcTemplate.update(sql, bolumId);
    }
    private static class BolumRowMapper implements RowMapper<Bolum> {
        @Override
        public Bolum mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bolum bolum = new Bolum();
            bolum.setBolum_id(rs.getInt("bolum_id"));
            bolum.setAd(rs.getString("ad"));
            return bolum;
        }
    }
}
