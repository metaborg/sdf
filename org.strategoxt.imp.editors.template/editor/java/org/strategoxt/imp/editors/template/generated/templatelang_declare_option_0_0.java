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
    Fail1117:
    { 
      IStrategoTerm term548 = term;
      Success470:
      { 
        Fail1118:
        { 
          TermReference u_32779 = new TermReference();
          IStrategoTerm v_32779 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consNewlines_1 != ((IStrategoAppl)term).getConstructor())
            break Fail1118;
          if(u_32779.value == null)
            u_32779.value = term.getSubterm(0);
          else
            if(u_32779.value != term.getSubterm(0) && !u_32779.value.match(term.getSubterm(0)))
              break Fail1118;
          v_32779 = term;
          lifted420 lifted4200 = new lifted420();
          lifted4200.u_32779 = u_32779;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted4200);
          if(term == null)
            break Fail1118;
          term = v_32779;
          if(true)
            break Success470;
        }
        term = term548;
        IStrategoTerm term549 = term;
        Success471:
        { 
          Fail1119:
          { 
            TermReference q_32779 = new TermReference();
            IStrategoTerm r_32779 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consKeywordFollowRestriction_1 != ((IStrategoAppl)term).getConstructor())
              break Fail1119;
            if(q_32779.value == null)
              q_32779.value = term.getSubterm(0);
            else
              if(q_32779.value != term.getSubterm(0) && !q_32779.value.match(term.getSubterm(0)))
                break Fail1119;
            r_32779 = term;
            lifted421 lifted4210 = new lifted421();
            lifted4210.q_32779 = q_32779;
            term = with_spxverify_1_0.instance.invoke(context, term, lifted4210);
            if(term == null)
              break Fail1119;
            term = r_32779;
            if(true)
              break Success471;
          }
          term = term549;
          TermReference l_32779 = new TermReference();
          TermReference m_32779 = new TermReference();
          IStrategoTerm n_32779 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consTokenize_1 != ((IStrategoAppl)term).getConstructor())
            break Fail1117;
          if(l_32779.value == null)
            l_32779.value = term.getSubterm(0);
          else
            if(l_32779.value != term.getSubterm(0) && !l_32779.value.match(term.getSubterm(0)))
              break Fail1117;
          n_32779 = term;
          lifted422 lifted4220 = new lifted422();
          lifted4220.l_32779 = l_32779;
          lifted4220.m_32779 = m_32779;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted4220);
          if(term == null)
            break Fail1117;
          term = n_32779;
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