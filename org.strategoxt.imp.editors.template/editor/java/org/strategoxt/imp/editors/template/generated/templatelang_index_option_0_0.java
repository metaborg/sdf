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
    Fail1115:
    { 
      TermReference i_32779 = new TermReference();
      TermReference j_32779 = new TermReference();
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1115;
      if(i_32779.value == null)
        i_32779.value = term.getSubterm(0);
      else
        if(i_32779.value != term.getSubterm(0) && !i_32779.value.match(term.getSubterm(0)))
          break Fail1115;
      if(j_32779.value == null)
        j_32779.value = term.getSubterm(1);
      else
        if(j_32779.value != term.getSubterm(1) && !j_32779.value.match(term.getSubterm(1)))
          break Fail1115;
      lifted417 lifted4170 = new lifted417();
      lifted4170.i_32779 = i_32779;
      lifted4170.j_32779 = j_32779;
      term = with_spxverify_2_0.instance.invoke(context, term, lifted4170, lifted418.instance);
      if(term == null)
        break Fail1115;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}