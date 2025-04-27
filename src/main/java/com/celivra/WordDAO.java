package com.celivra;

import com.celivra.Util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordDAO {
    Connection connection = DBUtil.getConnection();
    public void insertWord(Word word) {}
    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement("select * from word")){
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Word word = new Word();
                word.setId(rs.getLong("id"));
                word.setEnglish(rs.getString("english"));
                word.setChinese(rs.getString("chinese"));
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
        return words;
    }
}
