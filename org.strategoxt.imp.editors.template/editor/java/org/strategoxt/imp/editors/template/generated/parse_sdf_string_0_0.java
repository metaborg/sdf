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

@SuppressWarnings("all") public class parse_sdf_string_0_0 extends Strategy 
{ 
  public static parse_sdf_string_0_0 instance = new parse_sdf_string_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("parse_sdf_string_0_0");
    Fail365:
    { 
      IStrategoTerm p_9746 = null;
      p_9746 = term;
      term = get_sdf_parse_table_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail365;
      term = parse_string_1_1.instance.invoke(context, p_9746, strsglr_report_parse_error_0_0.instance, term);
      if(term == null)
        break Fail365;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}