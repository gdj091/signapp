package com.example.signapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.signapp.dto.Document;
import com.example.signapp.mapper.DocumentMapper;

@Service
public class DocumentService {

    @Autowired
    private DocumentMapper documentMapper;

    public boolean upload(Document document) {
        return documentMapper.insertDocument(document) > 0;
    }
    
    public List<Document> findAll() {
        return documentMapper.selectAllDocuments();
    }
}