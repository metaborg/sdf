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

@SuppressWarnings("all") public class bigchain_$Expanded_0_0 extends Strategy 
{ 
  public static bigchain_$Expanded_0_0 instance = new bigchain_$Expanded_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigchain_Expanded_0_0");
    Fail1394:
    { 
      IStrategoTerm a_32798 = null;
      IStrategoTerm d_32798 = null;
      IStrategoTerm f_32798 = null;
      a_32798 = term;
      f_32798 = term;
      Success531:
      { 
        Fail1395:
        { 
          IStrategoTerm h_32798 = null;
          h_32798 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, h_32798, generated.const217, a_32798);
          if(term == null)
            break Fail1395;
          if(true)
            break Success531;
        }
        term = generated.constNil3;
      }
      d_32798 = term;
      term = f_32798;
      term = termFactory.makeTuple(d_32798, term);
      term = foldl_1_0.instance.invoke(context, term, lifted505.instance);
      if(term == null)
        break Fail1394;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}