package org.metaborg.newsdf2table.dynamic;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.vfs2.FileObject;
import org.metaborg.newsdf2table.grammar.NormGrammar;
import org.metaborg.newsdf2table.parsetable.LRItem;
import org.metaborg.newsdf2table.parsetable.State;
import org.metaborg.util.log.ILogger;
import org.metaborg.util.log.LoggerUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class DynamicParseTableGenerator {
    
    private static final ILogger logger = LoggerUtils.logger(DynamicParseTableGenerator.class);
    private NormGrammar normGrammar;
    
    private Map<Set<LRItem>, State> kernel_states = Maps.newHashMap();
    List<State> states = Lists.newArrayList();

    public DynamicParseTableGenerator(FileObject grammar) {
        try {
            InputStream out = grammar.getContent().getInputStream();
            ObjectInputStream ois = new ObjectInputStream(out);
            // read persisted normalized grammar
            normGrammar  = (NormGrammar) ois.readObject();
            ois.close();
            out.close();
        } catch(Exception e) {
            logger.error("Could not load initial table.");
            e.printStackTrace();
        }
    }
    
    public State getInitialState(){
        return null;
    }

}
