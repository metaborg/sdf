package org.strategoxt.imp.editors.template.generated;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class templatelang_declare_option_0_0 extends Strategy 
{ 
  public static templatelang_declare_option_0_0 instance = new templatelang_declare_option_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("templatelang_declare_option_0_0");
    Fail297:
    { 
      IStrategoTerm term292 = term;
      Success214:
      { 
        Fail298:
        { 
          TermReference l_9741 = new TermReference();
          IStrategoTerm m_9741 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consNewlines_1 != ((IStrategoAppl)term).getConstructor())
            break Fail298;
          if(l_9741.value == null)
            l_9741.value = term.getSubterm(0);
          else
            if(l_9741.value != term.getSubterm(0) && !l_9741.value.match(term.getSubterm(0)))
              break Fail298;
          m_9741 = term;
          lifted221 lifted2210 = new lifted221();
          lifted2210.l_9741 = l_9741;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted2210);
          if(term == null)
            break Fail298;
          term = m_9741;
          if(true)
            break Success214;
        }
        term = term292;
        IStrategoTerm term293 = term;
        Success215:
        { 
          Fail299:
          { 
            TermReference h_9741 = new TermReference();
            IStrategoTerm i_9741 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consKeywordFollowRestriction_1 != ((IStrategoAppl)term).getConstructor())
              break Fail299;
            if(h_9741.value == null)
              h_9741.value = term.getSubterm(0);
            else
              if(h_9741.value != term.getSubterm(0) && !h_9741.value.match(term.getSubterm(0)))
                break Fail299;
            i_9741 = term;
            lifted222 lifted2220 = new lifted222();
            lifted2220.h_9741 = h_9741;
            term = with_spxverify_1_0.instance.invoke(context, term, lifted2220);
            if(term == null)
              break Fail299;
            term = i_9741;
            if(true)
              break Success215;
          }
          term = term293;
          TermReference c_9741 = new TermReference();
          TermReference d_9741 = new TermReference();
          IStrategoTerm e_9741 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consTokenize_1 != ((IStrategoAppl)term).getConstructor())
            break Fail297;
          if(c_9741.value == null)
            c_9741.value = term.getSubterm(0);
          else
            if(c_9741.value != term.getSubterm(0) && !c_9741.value.match(term.getSubterm(0)))
              break Fail297;
          e_9741 = term;
          lifted223 lifted2230 = new lifted223();
          lifted2230.c_9741 = c_9741;
          lifted2230.d_9741 = d_9741;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted2230);
          if(term == null)
            break Fail297;
          term = e_9741;
        }
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}