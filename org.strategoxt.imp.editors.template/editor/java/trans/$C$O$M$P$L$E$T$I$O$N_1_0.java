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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy c_10723)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("COMPLETION_1_0");
    Fail116:
    { 
      IStrategoTerm h_10901 = null;
      IStrategoTerm g_10901 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCOMPLETION_1 != ((IStrategoAppl)term).getConstructor())
        break Fail116;
      g_10901 = term.getSubterm(0);
      IStrategoList annos1 = term.getAnnotations();
      h_10901 = annos1;
      term = c_10723.invoke(context, g_10901);
      if(term == null)
        break Fail116;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCOMPLETION_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, h_10901));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}