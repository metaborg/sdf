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

@SuppressWarnings("all") public class templatelang_index_option_0_0 extends Strategy 
{ 
  public static templatelang_index_option_0_0 instance = new templatelang_index_option_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("templatelang_index_option_0_0");
    Fail295:
    { 
      TermReference z_9740 = new TermReference();
      TermReference a_9741 = new TermReference();
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail295;
      if(z_9740.value == null)
        z_9740.value = term.getSubterm(0);
      else
        if(z_9740.value != term.getSubterm(0) && !z_9740.value.match(term.getSubterm(0)))
          break Fail295;
      if(a_9741.value == null)
        a_9741.value = term.getSubterm(1);
      else
        if(a_9741.value != term.getSubterm(1) && !a_9741.value.match(term.getSubterm(1)))
          break Fail295;
      lifted218 lifted2180 = new lifted218();
      lifted2180.z_9740 = z_9740;
      lifted2180.a_9741 = a_9741;
      term = with_spxverify_2_0.instance.invoke(context, term, lifted2180, lifted219.instance);
      if(term == null)
        break Fail295;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}