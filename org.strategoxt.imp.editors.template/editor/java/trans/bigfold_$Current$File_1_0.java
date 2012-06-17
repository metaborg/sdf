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

@SuppressWarnings("all") public class bigfold_$Current$File_1_0 extends Strategy 
{ 
  public static bigfold_$Current$File_1_0 instance = new bigfold_$Current$File_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy l_33016)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigfold_CurrentFile_1_0");
    Fail2009:
    { 
      IStrategoTerm m_33016 = null;
      IStrategoTerm o_33016 = null;
      o_33016 = term;
      Success724:
      { 
        Fail2010:
        { 
          IStrategoTerm p_33016 = null;
          IStrategoTerm r_33016 = null;
          IStrategoTerm s_33016 = null;
          r_33016 = term;
          p_33016 = trans.const273;
          s_33016 = r_33016;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, s_33016, p_33016, trans.constCons84);
          if(term == null)
            break Fail2010;
          if(true)
            break Success724;
        }
        term = trans.constNil4;
      }
      m_33016 = term;
      term = o_33016;
      term = termFactory.makeTuple(m_33016, term);
      term = l_33016.invoke(context, term, lifted578.instance);
      if(term == null)
        break Fail2009;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}