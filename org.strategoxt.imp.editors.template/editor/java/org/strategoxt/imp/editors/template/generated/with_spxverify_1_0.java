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

@SuppressWarnings("all") public class with_spxverify_1_0 extends Strategy 
{ 
  public static with_spxverify_1_0 instance = new with_spxverify_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy r_32786)
  { 
    context.push("with_spxverify_1_0");
    Fail1190:
    { 
      term = with_verify_3_0.instance.invoke(context, term, r_32786, _Id.instance, lifted442.instance);
      if(term == null)
        break Fail1190;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}