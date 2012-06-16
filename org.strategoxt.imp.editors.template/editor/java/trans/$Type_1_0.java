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

@SuppressWarnings("all") public class $Type_1_0 extends Strategy 
{ 
  public static $Type_1_0 instance = new $Type_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy i_10723)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Type_1_0");
    Fail122:
    { 
      IStrategoTerm x_10901 = null;
      IStrategoTerm w_10901 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consType_1 != ((IStrategoAppl)term).getConstructor())
        break Fail122;
      w_10901 = term.getSubterm(0);
      IStrategoList annos5 = term.getAnnotations();
      x_10901 = annos5;
      term = i_10723.invoke(context, w_10901);
      if(term == null)
        break Fail122;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consType_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, x_10901));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}