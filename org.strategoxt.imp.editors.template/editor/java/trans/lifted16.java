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

@SuppressWarnings("all") final class lifted16 extends Strategy 
{ 
  Strategy t_10714;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail248:
    { 
      IStrategoTerm r_10714 = null;
      r_10714 = term;
      term = t_10714.invoke(context, term);
      if(term == null)
        break Fail248;
      IStrategoTerm term36 = term;
      Success69:
      { 
        Fail249:
        { 
          if(term != r_10714 && !r_10714.match(term))
            break Fail249;
          { 
            if(true)
              break Fail248;
            if(true)
              break Success69;
          }
        }
        term = term36;
      }
      if(true)
        return term;
    }
    return null;
  }
}