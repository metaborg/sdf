package trans;

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

@SuppressWarnings("all") public class reverse_bagof_$Current$File_1_0 extends Strategy 
{ 
  public static reverse_bagof_$Current$File_1_0 instance = new reverse_bagof_$Current$File_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_10732)
  { 
    context.push("reverse_bagof_CurrentFile_1_0");
    Fail172:
    { 
      TermReference f_10732 = new TermReference();
      if(f_10732.value == null)
        f_10732.value = term;
      else
        if(f_10732.value != term && !f_10732.value.match(term))
          break Fail172;
      Success58:
      { 
        Fail173:
        { 
          IStrategoTerm j_10732 = null;
          IStrategoTerm l_10732 = null;
          IStrategoTerm m_10732 = null;
          l_10732 = term;
          j_10732 = trans.const3;
          m_10732 = l_10732;
          term = dr_lookup_rule_0_2.instance.invoke(context, m_10732, j_10732, trans.constCons0);
          if(term == null)
            break Fail173;
          if(true)
            break Success58;
        }
        term = trans.constNil0;
      }
      lifted55 lifted550 = new lifted55();
      lifted550.f_10732 = f_10732;
      term = reverse_filter_2_0.instance.invoke(context, term, lifted550, h_10732);
      if(term == null)
        break Fail172;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}