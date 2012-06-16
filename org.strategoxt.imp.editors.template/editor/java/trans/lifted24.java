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

@SuppressWarnings("all") final class lifted24 extends Strategy 
{ 
  public static final lifted24 instance = new lifted24();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail240:
    { 
      IStrategoTerm term46 = term;
      IStrategoConstructor cons3 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success68:
      { 
        if(cons3 == Main._consTemplateSection_1)
        { 
          Fail241:
          { 
            if(true)
              break Success68;
          }
          term = term46;
        }
        if(cons3 == Main._consSDFSection_1)
        { }
        else
        { 
          break Fail240;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}