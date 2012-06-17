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

@SuppressWarnings("all") public class parse_sdf_file_0_0 extends Strategy 
{ 
  public static parse_sdf_file_0_0 instance = new parse_sdf_file_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("parse_sdf_file_0_0");
    Fail1186:
    { 
      IStrategoTerm c_32785 = null;
      c_32785 = term;
      term = get_sdf_parse_table_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1186;
      term = parse_file_2_1.instance.invoke(context, c_32785, strsglr_perror_0_0.instance, strsglr_report_parse_error_0_0.instance, term);
      if(term == null)
        break Fail1186;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}