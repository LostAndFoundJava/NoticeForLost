package com.nfl.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.nfl.pojo.NflUsers;

@Service("userIndexService")
public class UserIndexService implements IndexService<NflUsers>{

	public void add(NflUsers user) {
		Document doc = new Document();
		//doc.add(new StringField("user_email", user.getUserEmail(), Field.Store.YES));
		doc.add(new IntField("user_id", user.getId(), Field.Store.YES));
		doc.add(new StringField("user_name", user.getUserName(), Field.Store.YES));
		//doc.add(new StringField("user_phone", user.getUserPhone(),Field.Store.YES));
		//doc.add(new NumericDocValuesField("user_registered_date",user.getUserRegisteredDate().getTime()));
		try {
			IndexHolder.getIndexWriter().addDocument(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Integer> findUserByName(String username) {
		List<Integer> users = new ArrayList<Integer>();
//		Analyzer analyzer=new StandardAnalyzer();
		Analyzer analyzer = new IKAnalyzer();
		QueryParser parser = new QueryParser("user_name", analyzer);
		Query query;
		try {
			query = parser.parse(username);
			IndexSearcher searcher = IndexHolder.getIndexSearcher();
			TopDocs docs = searcher.search(query, 10);
			ScoreDoc[] sds =docs.scoreDocs;
			System.out.println(sds.length);
			for(ScoreDoc sd: sds){
				Document doc = searcher.doc(sd.doc);
				users.add(Integer.valueOf(doc.get("user_id")));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

}
