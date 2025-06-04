package com.example.signapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.signapp.dto.Document;

@Mapper
public interface DocumentMapper {
    int insertDocument(Document document);
    List<Document> selectAllDocuments();
}