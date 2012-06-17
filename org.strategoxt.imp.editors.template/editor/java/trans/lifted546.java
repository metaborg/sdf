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

@SuppressWarnings("all") final class lifted546 extends Strategy 
{ 
  Strategy g_33000;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2096:
    { 
      IStrategoTerm e_33000 = null;
      e_33000 = term;
      term = g_33000.invoke(context, term);
      if(term == null)
        break Fail2096;
      IStrategoTerm term702 = term;
      Success740:
      { 
        Fail2097:
        { 
          if(term != e_33000 && !e_33000.match(term))
            break Fail2097;
          { 
            if(true)
              break Fail2096;
            if(true)
              break Success740;
          }
        }
        term = term702;
      }
      if(true)
        return term;
    }
    return null;
  }
}