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

@SuppressWarnings("all") public class $Unmanaged$Table$Prefix_1_0 extends Strategy 
{ 
  public static $Unmanaged$Table$Prefix_1_0 instance = new $Unmanaged$Table$Prefix_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy c_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("UnmanagedTablePrefix_1_0");
    Fail469:
    { 
      IStrategoTerm a_9930 = null;
      IStrategoTerm z_9929 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consUnmanagedTablePrefix_1 != ((IStrategoAppl)term).getConstructor())
        break Fail469;
      z_9929 = term.getSubterm(0);
      IStrategoList annos42 = term.getAnnotations();
      a_9930 = annos42;
      term = c_9753.invoke(context, z_9929);
      if(term == null)
        break Fail469;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consUnmanagedTablePrefix_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, a_9930));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}