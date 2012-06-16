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

@SuppressWarnings("all") public class $Identifier$Lexical_1_0 extends Strategy 
{ 
  public static $Identifier$Lexical_1_0 instance = new $Identifier$Lexical_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy x_9752)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("IdentifierLexical_1_0");
    Fail464:
    { 
      IStrategoTerm l_9929 = null;
      IStrategoTerm k_9929 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consIdentifierLexical_1 != ((IStrategoAppl)term).getConstructor())
        break Fail464;
      k_9929 = term.getSubterm(0);
      IStrategoList annos37 = term.getAnnotations();
      l_9929 = annos37;
      term = x_9752.invoke(context, k_9929);
      if(term == null)
        break Fail464;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consIdentifierLexical_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, l_9929));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}