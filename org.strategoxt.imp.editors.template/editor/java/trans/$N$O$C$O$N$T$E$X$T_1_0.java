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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy t_33009)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("NOCONTEXT_1_0");
    Fail1963:
    { 
      IStrategoTerm a_33188 = null;
      IStrategoTerm z_33187 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consNOCONTEXT_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1963;
      z_33187 = term.getSubterm(0);
      IStrategoList annos134 = term.getAnnotations();
      a_33188 = annos134;
      term = t_33009.invoke(context, z_33187);
      if(term == null)
        break Fail1963;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consNOCONTEXT_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, a_33188));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}