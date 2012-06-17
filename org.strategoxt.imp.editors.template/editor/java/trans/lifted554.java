package trans;

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

@SuppressWarnings("all") final class lifted554 extends Strategy 
{ 
  public static final lifted554 instance = new lifted554();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2088:
    { 
      IStrategoTerm term712 = term;
      IStrategoConstructor cons72 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success739:
      { 
        if(cons72 == Main._consTemplateSection_1)
        { 
          Fail2089:
          { 
            if(true)
              break Success739;
          }
          term = term712;
        }
        if(cons72 == Main._consSDFSection_1)
        { }
        else
        { 
          break Fail2088;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}