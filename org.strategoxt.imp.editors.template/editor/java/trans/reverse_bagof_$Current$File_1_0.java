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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy x_33018)
  { 
    context.push("reverse_bagof_CurrentFile_1_0");
    Fail2020:
    { 
      TermReference v_33018 = new TermReference();
      if(v_33018.value == null)
        v_33018.value = term;
      else
        if(v_33018.value != term && !v_33018.value.match(term))
          break Fail2020;
      Success729:
      { 
        Fail2021:
        { 
          IStrategoTerm z_33018 = null;
          IStrategoTerm b_33019 = null;
          IStrategoTerm c_33019 = null;
          b_33019 = term;
          z_33018 = trans.const273;
          c_33019 = b_33019;
          term = dr_lookup_rule_0_2.instance.invoke(context, c_33019, z_33018, trans.constCons84);
          if(term == null)
            break Fail2021;
          if(true)
            break Success729;
        }
        term = trans.constNil4;
      }
      lifted584 lifted5840 = new lifted584();
      lifted5840.v_33018 = v_33018;
      term = reverse_filter_2_0.instance.invoke(context, term, lifted5840, x_33018);
      if(term == null)
        break Fail2020;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}