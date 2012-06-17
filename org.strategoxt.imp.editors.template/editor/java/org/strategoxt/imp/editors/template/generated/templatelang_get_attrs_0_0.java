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

@SuppressWarnings("all") public class templatelang_get_attrs_0_0 extends Strategy 
{ 
  public static templatelang_get_attrs_0_0 instance = new templatelang_get_attrs_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1081:
    { 
      IStrategoTerm term502 = term;
      IStrategoConstructor cons31 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success448:
      { 
        if(cons31 == Main._consno_attrs_0)
        { 
          Fail1082:
          { 
            term = generated.constNil3;
            if(true)
              break Success448;
          }
          term = term502;
        }
        if(cons31 == Main._consattrs_1)
        { 
          IStrategoTerm l_32773 = null;
          l_32773 = term.getSubterm(0);
          term = l_32773;
        }
        else
        { 
          break Fail1081;
        }
      }
      if(true)
        return term;
    }
    context.push("templatelang_get_attrs_0_0");
    context.popOnFailure();
    return null;
  }
}