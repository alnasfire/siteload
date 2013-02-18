package by.siteload.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class SearchHelper {
    public List<String> getResults(String words) {
        List<String> results = new ArrayList<String>();
        String url = "http://localhost:8983/solr";
        CommonsHttpSolrServer solr = null;
        try {
            solr = new CommonsHttpSolrServer(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        solr.setParser(new XMLResponseParser());
        solr.setAllowCompression(true);

        SolrQuery query = new SolrQuery();
        query.setQuery(words);
        try {
            QueryResponse rsp = solr.query(query);
            SolrDocumentList docs = rsp.getResults();
            try {
                for (SolrDocument doc : docs) {
                    String s = doc.getFieldValue("id").toString();
                    results.add(s);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return results;
    }
}