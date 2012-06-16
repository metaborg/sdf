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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm w_9723)
  { 
    Fail149:
    { 
      IStrategoTerm term156 = term;
      Success105:
      { 
        Fail150:
        { 
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail150;
          IStrategoTerm arg207 = ((IStrategoList)term).tail();
          if(arg207.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg207).isEmpty())
            break Fail150;
          if(true)
            break Success105;
        }
        term = term156;
        if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
          break Fail149;
        IStrategoTerm arg210 = ((IStrategoList)term).head();
        if(arg210.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)arg210).getConstructor())
          break Fail149;
      }
      if(true)
        return term;
    }
    context.push("accept_template_parts_0_1");
    context.popOnFailure();
    return null;
  }
}