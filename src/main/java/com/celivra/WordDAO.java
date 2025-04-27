package com.celivra;

import com.celivra.Util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordDAO {
    Connection connection = DBUtil.getConnection();
    public boolean insertWord(Word word) {
        try(PreparedStatement ps = connection.prepareStatement("insert into word(english, chinese) values(?, ?)")) {
            ps.setString(1, word.getEnglish());
            ps.setString(2, word.getChinese());
            ResultSet rs = ps.executeQuery();
            return true;
        }catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement("select * from word")){
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Word word = new Word();
                word.setId(rs.getLong("id"));
                word.setEnglish(rs.getString("english"));
                word.setChinese(rs.getString("chinese"));
                words.add(word);
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
        return words;
    }
}
