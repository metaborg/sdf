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

@SuppressWarnings("all") public class bagof_$Current$File_0_0 extends Strategy 
{ 
  public static bagof_$Current$File_0_0 instance = new bagof_$Current$File_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bagof_CurrentFile_0_0");
    Fail2022:
    { 
      TermReference d_33019 = new TermReference();
      if(d_33019.value == null)
        d_33019.value = term;
      else
        if(d_33019.value != term && !d_33019.value.match(term))
          break Fail2022;
      Success730:
      { 
        Fail2023:
        { 
          IStrategoTerm g_33019 = null;
          IStrategoTerm i_33019 = null;
          IStrategoTerm j_33019 = null;
          i_33019 = term;
          g_33019 = trans.const273;
          j_33019 = i_33019;
          term = dr_lookup_rule_0_2.instance.invoke(context, j_33019, g_33019, trans.constCons84);
          if(term == null)
            break Fail2023;
          if(true)
            break Success730;
        }
        term = trans.constNil4;
      }
      lifted585 lifted5850 = new lifted585();
      lifted5850.d_33019 = d_33019;
      term = filter_1_0.instance.invoke(context, term, lifted5850);
      if(term == null)
        break Fail2022;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}