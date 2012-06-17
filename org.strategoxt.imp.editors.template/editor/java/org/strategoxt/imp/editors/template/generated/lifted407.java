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

@SuppressWarnings("all") final class lifted407 extends Strategy 
{ 
  public static final lifted407 instance = new lifted407();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1601:
    { 
      IStrategoTerm y_32774 = null;
      IStrategoTerm a_32775 = null;
      IStrategoTerm b_32775 = null;
      a_32775 = term;
      y_32774 = generated.const206;
      b_32775 = a_32775;
      term = string_replace_0_2.instance.invoke(context, b_32775, y_32774, generated.const205);
      if(term == null)
        break Fail1601;
      if(true)
        return term;
    }
    return null;
  }
}