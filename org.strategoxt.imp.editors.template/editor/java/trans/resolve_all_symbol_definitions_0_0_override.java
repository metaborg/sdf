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

@SuppressWarnings("all") final class resolve_all_symbol_definitions_0_0_override extends resolve_all_symbol_definitions_0_0 
{ 
  private static final resolve_all_symbol_definitions_0_0 proceed = new resolve_all_symbol_definitions_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("resolve_all_symbol_definitions_0_0");
    Fail1844:
    { 
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1844;
      term = bagof_$Declaration_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1844;
      term = nub_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1844;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }

  @Override public String getName()
  { 
    return "resolve_all_symbol_definitions_0_0";
  }
}