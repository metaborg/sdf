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

@SuppressWarnings("all") public class accept_template_parts_0_1 extends Strategy 
{ 
  public static accept_template_parts_0_1 instance = new accept_template_parts_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm f_32762)
  { 
    Fail969:
    { 
      IStrategoTerm term412 = term;
      Success361:
      { 
        Fail970:
        { 
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail970;
          IStrategoTerm arg360 = ((IStrategoList)term).tail();
          if(arg360.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg360).isEmpty())
            break Fail970;
          if(true)
            break Success361;
        }
        term = term412;
        if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
          break Fail969;
        IStrategoTerm arg363 = ((IStrategoList)term).head();
        if(arg363.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)arg363).getConstructor())
          break Fail969;
      }
      if(true)
        return term;
    }
    context.push("accept_template_parts_0_1");
    context.popOnFailure();
    return null;
  }
}