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

@SuppressWarnings("all") public class $C$O$M$P$L$E$T$I$O$N_1_0 extends Strategy 
{ 
  public static $C$O$M$P$L$E$T$I$O$N_1_0 instance = new $C$O$M$P$L$E$T$I$O$N_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy s_33009)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("COMPLETION_1_0");
    Fail1962:
    { 
      IStrategoTerm x_33187 = null;
      IStrategoTerm w_33187 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCOMPLETION_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1962;
      w_33187 = term.getSubterm(0);
      IStrategoList annos133 = term.getAnnotations();
      x_33187 = annos133;
      term = s_33009.invoke(context, w_33187);
      if(term == null)
        break Fail1962;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCOMPLETION_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, x_33187));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}