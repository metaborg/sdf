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

@SuppressWarnings("all") public class $N$O$C$O$N$T$E$X$T_1_0 extends Strategy 
{ 
  public static $N$O$C$O$N$T$E$X$T_1_0 instance = new $N$O$C$O$N$T$E$X$T_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy d_10723)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("NOCONTEXT_1_0");
    Fail117:
    { 
      IStrategoTerm k_10901 = null;
      IStrategoTerm j_10901 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consNOCONTEXT_1 != ((IStrategoAppl)term).getConstructor())
        break Fail117;
      j_10901 = term.getSubterm(0);
      IStrategoList annos2 = term.getAnnotations();
      k_10901 = annos2;
      term = d_10723.invoke(context, j_10901);
      if(term == null)
        break Fail117;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consNOCONTEXT_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, k_10901));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}