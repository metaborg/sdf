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

@SuppressWarnings("all") public class parse_stratego_string_0_0 extends Strategy 
{ 
  public static parse_stratego_string_0_0 instance = new parse_stratego_string_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("parse_stratego_string_0_0");
    Fail1183:
    { 
      IStrategoTerm u_32784 = null;
      u_32784 = term;
      term = get_parse_table_from_ast_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1183;
      term = parse_string_1_1.instance.invoke(context, u_32784, strsglr_report_parse_error_0_0.instance, term);
      if(term == null)
        break Fail1183;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}